package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello",20);

        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member resultMember = memberRepository.findById(saveMember.getId());

        assertThat(resultMember.getUsername()).isEqualTo(member.getUsername());
    }

    @Test
    void findAll(){
        Member member1= new Member("hello",20);
        Member member2= new Member("world",30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> memberRepositoryAll = memberRepository.findAll();

        assertThat(memberRepositoryAll.size()).isEqualTo(2);
        assertThat(memberRepositoryAll).contains(member1,member2);

        for (Member member : memberRepositoryAll) {
            Member byId = memberRepository.findById(member.getId());

            assertThat(member.getId()).isEqualTo(byId.getId());
            assertThat(member.getUsername()).isEqualTo(byId.getUsername());
            assertThat(member.getAge()).isEqualTo(byId.getAge());
        }

    }

}