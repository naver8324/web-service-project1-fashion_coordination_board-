package com.elice.boardproject;

import com.elice.boardproject.entity.Board;
import com.elice.boardproject.repository.BoardRepository;
import com.elice.boardproject.entity.Comment;
import com.elice.boardproject.repository.CommentRepository;
import com.elice.boardproject.entity.Post;
import com.elice.boardproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class DataInit {

    private final BoardRepository boardRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info("init stub data");
        boardRepository.create(new Board("코디추천", "코디를 추천 받을 수 있는 게시판입니다."));
        boardRepository.create(new Board("공지사항", "공지사항 게시판입니다."));
        boardRepository.create(new Board("자주 찾는 FAQ", "자주 찾는 FAQ에 대한 게시판입니다."));
        boardRepository.create(new Board("주문 관련", "주문에 관련된 안내사항 게시판입니다."));
        boardRepository.create(new Board("배송 관련", "배송에 관련된 안내사항 게시판입니다."));
        boardRepository.create(new Board("문의 사항", "문의들을 관리하는 게시판입니다."));
        Board board = boardRepository.findById(1L).orElseThrow(() -> new RuntimeException());
        Board board2 = boardRepository.findById(2L).orElseThrow(() -> new RuntimeException());

        postRepository.save(new Post(board,"181cm 75kg M", "평소에 안 입어본 스타일로 입어보고 싶어서 무난하기보다 포인트 있는 룩으로 스타일 가리지 않고 추천해주세요."));
        postRepository.save(new Post(board, "152cm 42kg F 캐주얼 ", "캐주얼하게 평상시에 입기 좋은 룩으로 코디해주세요."));
        postRepository.save(new Post(board, "167cm 55kg F", "Comment 없음"));
        postRepository.save(new Post(board, "171cm 60kg M 스트릿", "악세사리를 좋아해서 목걸이 피어싱 팔찌 등 다양하게 섞어서 코디해주세요."));
        postRepository.save(new Post(board, "163cm 60kg F dior", "나이가 좀 있어서 어려보이지 않고 고급스럽게 dior 제품 위주로 코디해주세요."));
        postRepository.save(new Post(board, "169cm 59kg M 댄디 라퍼지스토어 ", "Comment 없음"));
        postRepository.save(new Post(board, "179cm 80kg M ", "Comment 없음"));
        postRepository.save(new Post(board, "176cm 58kg M ", "Comment 없음"));
        postRepository.save(new Post(board, "161cm 55kg F 클래식 prada", "모두 prada 제품으로 풀착장 코디해주세요."));
        postRepository.save(new Post(board, "155cm 41kg F ", "Comment 없음"));
        postRepository.save(new Post(board, "175cm 65kg M", "Comment 없음"));
        postRepository.save(new Post(board2, "네이버페이로 구매 시 주문 확인 방법 및 교환/반품 요청 안내", "결제수단 - 네이버페이 주문 확인 방법\n" +
                "\n" +
                "[교환/반품요청]시에, 입점 쇼핑몰의 계약 택배사가 다르기 때문에, 네이버페이-자동수거 지시가 불가합니다. \n" +
                "\n" +
                "출고 운송장번호 배달완료 날짜 기준으로, 7일 이내 구매 상품 쇼핑몰 측에 도착해야 합니다. \n" +
                "\n" +
                "따라서, 가급적이면 배달완료 날짜 기준으로 2일 이내 [교환/반품요청] 부탁드릴게요.\n" +
                "\n" +
                "감사합니다. "));
        postRepository.save(new Post(board2, "이벤트 당첨자 발표", "과거 진행되었던 미니 컨테스트 당첨자를 발표합니다."+
        "- elice1\n"+
        "- elice2\n"+
        "- elice3\n"+
        "- elice4\n"+
        "위 5분에게는  상품 가격 20,000원을 적립금으로 지급 해 드렸습니다"+
        "참여 해 주신 모든 분들께 감사드립니다."));
        Post post = postRepository.findById(1L).orElseThrow(() -> new RuntimeException());
        Post post2 = postRepository.findById(12L).orElseThrow(() -> new RuntimeException());

        commentRepository.save(new Comment(post, "요새 다시 화제가 되는 젠더리스 스타일로 코디해보았어요.\n"+
                "좀 여성스러운 느낌이 보일 수 있는 라운지넥에 실크한 블레이저와 가볍게 포인트 주기 좋은 금목걸이를 매치했어요."));
        commentRepository.save(new Comment(post, "고객님이 안 입어본 스타일로 입어보고 싶다고 하셔서 그런지룩으로 준비해보았어요."+
                "찢어진 청바지에 하이부츠, 와이드한 티셔츠로 자유로우면서 시선이 가는 룩입니다."));
        commentRepository.save(new Comment(post2, "다음 이벤트는 언제 열리나요?"));
        commentRepository.save(new Comment(post2, "다음은 당첨자 10명으로 안될까요? ㅠㅠ"));
    }
}
