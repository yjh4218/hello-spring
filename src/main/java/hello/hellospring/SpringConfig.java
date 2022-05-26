package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    //JPA는 자동으로 interface를 구현하지 않아도 자동으로 구현해서 Bean으로 등록한다.
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    } // @Service 구현


//    @Bean
//    public MemberRepository memberRepository(){

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    } // @Repository 구현
}
