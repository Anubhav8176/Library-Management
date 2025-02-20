package com.anucodes.Library.services;


import com.anucodes.Library.entity.Book;
import com.anucodes.Library.entity.Borrow;
import com.anucodes.Library.entity.Member;
import com.anucodes.Library.model.BorrowDto;
import com.anucodes.Library.repository.BookRepository;
import com.anucodes.Library.repository.BorrowRepository;
import com.anucodes.Library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Boolean addBorrow(BorrowDto borrowDto){
        try{

            Book selectedbook;
            Member member;
            if (bookRepository.findById(borrowDto.bookId()).isPresent()){
                selectedbook = bookRepository.findById(borrowDto.bookId()).get();
            }else{
                throw new RuntimeException("No book found with id!!");
            }

            if (memberRepository.findById(borrowDto.memberId()).isPresent()){
                member = memberRepository.findById(borrowDto.memberId()).get();
            }else{
                throw new RuntimeException("No member found with id!");
            }

            if (selectedbook.getAvailableCopies()>0){
                Borrow borrow = new Borrow(
                        selectedbook,
                        member,
                        borrowDto.issuedAt(),
                        borrowDto.returnedAt(),
                        borrowDto.returned()
                );
                borrowRepository.save(borrow);
                return true;
            }else{
                throw new RuntimeException("No copies of the book available!!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }

}
