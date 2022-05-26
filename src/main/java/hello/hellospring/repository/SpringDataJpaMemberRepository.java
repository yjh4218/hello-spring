package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //JpaRepository<Member, Long>는 Member. 즉 domain으로 DB에 저장할 클래스와 Long 타입. PK의 타입을 넣으면 된다.

    //select m from Member m where m.name=?
    @Override
    Optional<Member> findByName(String name);


}
