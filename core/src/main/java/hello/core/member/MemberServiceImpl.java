package hello.core.member;

public class MemberServiceImpl implements MemberService {

    /**
     * 현재 코드는 추상화 MemberRepository와 구체화 MemoryMemberRepository 둘 다 의존하는 중
     * => DIP 위반
     * 추상화에만 의존하도록 수정
     */

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
