package com.anucodes.Library.controller;


import com.anucodes.Library.model.MemberDto;
import com.anucodes.Library.services.BookServices;
import com.anucodes.Library.services.MemberServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/member")
public class MemberController {

    @Autowired
    private MemberServices memberServices;

    @GetMapping("/getAll")
    public ResponseEntity getAllMember(){
        try {
           List<MemberDto> member =  memberServices.getAllMembers();
           return new ResponseEntity(member, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addMemeber(MemberDto memberDto){
        try{
            memberServices.addNewMembers(memberDto);
            return new ResponseEntity<>("New Member Added", HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
