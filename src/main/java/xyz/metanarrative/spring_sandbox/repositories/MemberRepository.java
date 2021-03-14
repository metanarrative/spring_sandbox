package xyz.metanarrative.spring_sandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.metanarrative.spring_sandbox.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findMemberById(int id);

}
