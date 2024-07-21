package Spring.Module2.SpringM2.LibraryMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("path = LibraryMembers")
public class LibraryMemberController {
    private final LibraryMembersService libraryMembersService;

    @Autowired
    public LibraryMemberController(LibraryMembersService libraryMembersService) {
        this.libraryMembersService = libraryMembersService;
    }

    @GetMapping(path = "AllLibraryMembers")
    public List<LibraryMembers> getMembers(){
        return libraryMembersService.getAllLibraryMembers();
    }

    @PostMapping(path = "CreateNewLibraryMember")
    public void addMember(@RequestBody LibraryMembers member){
        libraryMembersService.addLibraryMember(member);
    }

    @DeleteMapping(path = "deleteMember/{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId){
        libraryMembersService.deleteLibraryMember(memberId);
    }

    @PutMapping(path = "Change{memberId}firstName")
    public void updateMemberFirstName(
            @PathVariable("memberId") Long memberId,
            @RequestParam(required = false) String firstName){
                libraryMembersService.updateLibraryMemberFirstName(memberId, firstName);
    }
    @PutMapping(path = "Change{memberId}lastName")
    public void updateMemberLastName(
            @PathVariable("memberId") Long memberId,
            @RequestParam(required = false) String lastName){
        libraryMembersService.updateLibraryMemberLastName(memberId, lastName);
    }
}
