package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Beans.covidcases;

public interface covidcaseRepository extends JpaRepository<covidcases,String>{

}
