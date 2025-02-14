package com.anucodes.Library.services;

import com.anucodes.Library.entity.Member;
import com.anucodes.Library.model.MemberDto;
import com.anucodes.Library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServices {

    @Autowired
    private MemberRepository memberRepository;

    //Get all members
    public List<MemberDto> getAllMembers(){
        try {
            List<Member> allMembers = memberRepository.findAll();
            return allMembers.stream()
                    .map(member ->
                            new MemberDto(
                                    member.getName(),
                                    member.getEmail(),
                                    member.getPhone(),
                                    member.getMembershipDate()
                            )
                    ).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    //Adding new members
    public Boolean addNewMembers(MemberDto memberDto){
        try{
            Member newMember = new Member(
                    memberDto.name(),
                    memberDto.email(),
                    memberDto.phone(),
                    memberDto.membershipDate()
            );
            memberRepository.save(newMember);
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
