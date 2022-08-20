// package com.example.demo.repository;
// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.demo.Model.Talent_info;

// public interface Talent_infoRepo extends JpaRepository<Talent_info,Long> {
// //     @Query("select t_info from talent_info t_info INNER JOIN expert_tb ex_tb "+
// //     "ON t_info.id = ex_tb.ex_id INNER JOIN talent_tb t_tb " +
// //     "ON t_tb.talent_id = ex_tb.ex_id WHERE ex_tb.ex_id='3' AND t_info.talent=(:t_id)")
// // List<Talent_info> findAll(@Param("t_id") Long t_idLong);
// // @Query("select a.*,b.* , c.* from expert_tb a ,talent_tb b, talent_info c WHERE a.ex_id = c.ex_id and b.talent_id = c.talent_id; ")
// //         List<Talent_info> findAll(@Param("id") Long id);


// }
