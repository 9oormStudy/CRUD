package board.crud.Service;

import board.crud.entity.Post;
import board.crud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    // 1. 게시글 등록
    public Post createPost(Post post) {
        return repository.save(post);
    }

    // 2. 게시글 삭제
    public void deletePost(Long id) {
        repository.delete(id);
    }

    // 3. 게시글 수정
    public Post updatePost(Long id, Post post) {
        return repository.update(id, post);
    }

    // 4. 게시글 조회
    public Post getPostById(Long id) {
        return repository.findById(id);
    }

    // 5. 게시글 목록 조회
    public List<String> getAllPosts() {
        return repository.findAll();
    }
}
