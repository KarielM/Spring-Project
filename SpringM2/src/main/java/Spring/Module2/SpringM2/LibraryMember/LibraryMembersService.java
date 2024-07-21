package Spring.Module2.SpringM2.LibraryMember;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryMembersService {
    private final LibraryMemberRepository libraryMemberRepository;

    @Autowired
    public LibraryMembersService(LibraryMemberRepository libraryMemberRepository) {
        this.libraryMemberRepository = libraryMemberRepository;
    }
    public List<LibraryMembers> getAllLibraryMembers(){
       return libraryMemberRepository.findAll();
    }
    public void addLibraryMember(LibraryMembers libraryMember){
        libraryMemberRepository.save(libraryMember);
    }

    public void deleteLibraryMember(Long memberId){
        boolean memberFound = libraryMemberRepository.existsById(memberId);
        if (!memberFound){
            throw new IllegalStateException("Member does not exist");
        }
        libraryMemberRepository.deleteById(memberId);
    }

    @Transactional
    public void updateLibraryMemberFirstName(Long memberId, String firstName){
       LibraryMembers libraryMember = libraryMemberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("Member does not exist"));
       if (firstName != null && !firstName.isEmpty() && !Objects.equals(libraryMember.getFirstName(), firstName)){
           libraryMember.setFirstName(firstName);
       }
    }

    @Transactional
    public void updateLibraryMemberLastName(Long memberId, String lastName){
        LibraryMembers libraryMember = libraryMemberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("Member does not exist"));
        if (lastName != null && !lastName.isEmpty() && !Objects.equals(libraryMember.getFirstName(), lastName)){
            libraryMember.setFirstName(lastName);
        }
    }
}
