package com.backend.repository;

import com.backend.dto.CheckPoint;
import com.backend.dto.request.CheckPointRequest;
import com.backend.dto.request.InProgressCreateRequest;
import com.backend.dto.response.InProgressMissionResponse;
import com.backend.dto.response.MissionCheckPointResponse;
import com.backend.dto.response.MissionCompleteResponse;
import com.backend.dto.response.RouteResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class MissionRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<InProgressMissionResponse> findInProgressMission(String loginId) {
        String sql = """
               select
               ipm.mission_id AS missionId,
               ipm.user_id AS userId,
               ipm.route_id AS routeId,
               re.route_description AS routeDescription,
               re.route_name AS routeName,
               COALESCE(ct.is_complete, FALSE) AS isComplete
               from in_progress_mission ipm left join
               route re on ipm.route_id = re.route_id
               left join complete_route_table ct
               on re.route_id = ct.route_id
               where ipm.user_id = ? or ct.route_id is null;
               """;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(InProgressMissionResponse.class),
                loginId);
    }

    public List<InProgressMissionResponse> getCheckPoints(String loginId, List<InProgressMissionResponse> response) {
        for (InProgressMissionResponse missionResponse : response) {

        String sql = """
           select  
               cp.checkpoint_id AS checkPointId,
               cp.name AS name,
               cp.latitude AS latitude,
               cp.longitude AS longitude,       
               cp.address AS address,
               cp.description AS description,     
               cp.img_urls AS imgUrls,
               CASE
                   WHEN ccp.checkpoint_id IS NOT NULL THEN TRUE
                   ELSE FALSE
               END AS isComplete
           from check_points cp left join 
               complete_check_points ccp on cp.checkpoint_id = ccp.checkpoint_id
               where cp.route_id = ?
               """;

            missionResponse.setCheckPoint(jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(CheckPoint.class),
                missionResponse.getRouteId()
            ));
        }
        return response;
    }


    public int createInProgressMission(InProgressCreateRequest request) {
        String sql = """
            INSERT INTO in_progress_mission
                    (route_id, user_id, started_at, completed_at)
            VALUES  (?, ?, NOW(), ?)
        """;

        return jdbcTemplate.update(
                sql,
                request.getRouteId(),
                request.getUserId(),
                null
        );

    }

    public List<RouteResponse> findRoute(String userId) {
        String sql = """
            SELECT
                a.route_id AS routeId,
                a.route_name AS routeName,
                a.difficulty AS difficulty,
                a.approx_location AS approxLocation,
                a.tags AS tags,
                a.expected_distance AS expectedDistance,
                a.route_description AS routeDescription,
                COALESCE(b.is_complete, FALSE) AS isComplete
            FROM route a
            LEFT JOIN complete_route_table b
            ON b.route_id = a.route_id
            where b.user_id = ? or b.route_id is null;
        """;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(RouteResponse.class),
                userId
        );
    }

    public List<MissionCheckPointResponse> getInProgressMission(String userId, Long missionId) {
        String sql = """
               SELECT
                      id               AS missionId,
                      user_id          AS userId,
                      route_id         AS routeId,
                      started_at       AS startedAt,
                      completed_at     AS completedAt,
                      created_at       AS createdAt,
                      update_at       AS updatedAt
               FROM in_progress_mission
               WHERE user_id = ? and mission_id = ?
               """;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(MissionCheckPointResponse.class),
                userId, missionId);
    }

    public int createCheckPoint(CheckPointRequest request) {
        String sql = """
              INSERT INTO complete_check_points (
                                           mission_id,
                                           checkpoint_id,
                                           user_id
                                       ) VALUES (
                                           ?,
                                           ?,
                                           ?
                                       );
               """;

        return jdbcTemplate.update(
                sql,
                request.getMissionId(),
                request.getCheckpointId(),
                request.getUserId()
        );
    }

    public List<MissionCompleteResponse> findInProgressMissionComplete(String userId) {
        String sql = """
               SELECT
                      id               AS missionId,
                      user_id          AS userId,
                      route_id         AS routeId,
                      started_at       AS startedAt,
                      completed_at     AS completedAt,
                      created_at       AS createdAt,
                      update_at       AS updatedAt
               FROM in_progress_mission
               WHERE user_id = ? and mission_id = ?
               """;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(MissionCompleteResponse.class),
                userId);
    }



}
