package com.example.springaopexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class SelfInvocationTest {  
  

    @Autowired
    private SelfInvocation selfInvocation;
  
    @Autowired  
    private MemberRepository memberRepository;
  
    @AfterEach
    void tearDown() {  
        memberRepository.deleteAllInBatch();  
    }  
  
    @Test  
    void aopProxyTest() {  
        // @Transactional 애너테이션을 가지고 있으므로, 빈이 Proxy 객체로 대체되어 주입된다.  
        assertThat(AopUtils.isAopProxy(selfInvocation)).isTrue();
        // interface를 구현하지 않은 클래스이므로 CGLIB Proxy가 생성된다.  
        assertThat(AopUtils.isCglibProxy(selfInvocation)).isTrue();
    }  
  
    @Test
    void outerSaveWithPublic() {  
        Member member = new Member("test");
  
        try {  
            selfInvocation.outerSaveWithPublic(member);  
        } catch (RuntimeException e) {  
            log.info("catch exception");  
        }  
  
        List<Member> members = memberRepository.findAll();
        // self invocation 문제로 인해 트랜잭션이 정상 동작하지 않음.  
        // 예외 발생으로 인한 롤백이 동작하지 않고 남아있음.
    
      assertThat(members).hasSize(1);
    }  
  
    @Test  
    void outerSaveWithPrivate() {  
        try {  
            selfInvocation.outerSaveWithPrivate(new Member("test"));  
        } catch (RuntimeException e) {  
            log.info("catch exception");  
        }  
  
        List<Member> members = memberRepository.findAll();  
  
        // self invocation 문제로 인해 트랜잭션이 정상 동작하지 않음.  
        // 예외 발생으로 인한 롤백이 동작하지 않고 남아있음.        assertThat(members).hasSize(1);  
    }  
  
    @Test  
    void saveWithPublic() {  
        Member member = new Member("test");  
  
        try {  
            selfInvocation.saveWithPublic(member);  
        } catch (RuntimeException e) {  
            log.info("catch exception");  
        }  
  
        List<Member> members = memberRepository.findAll();  
  
        // 외부에서 프록시 객체를 통해 메서드가 호출되었기 때문에 트랜잭션 정상 동작, 롤백 성공.  
        assertThat(members).hasSize(0);  
    }  
}