package pe.oh29oh29.develogm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.oh29oh29.develogm.model.Comment;
import pe.oh29oh29.develogm.model.request.CommentReq;
import pe.oh29oh29.develogm.model.response.CommentRes;
import pe.oh29oh29.develogm.repository.CommentRepository;
import pe.oh29oh29.develogm.repository.specification.CommentSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentRes> getComments(CommentReq commentReq) {

        List<Comment> comments = commentRepository.findAll(CommentSpec.equalPost(commentReq), new Sort(Sort.Direction.ASC, Arrays.asList("ordering", "subOrdering")));

        List<CommentRes> commentResList = new ArrayList<>();
        comments.forEach(comment -> {
            CommentRes commentRes = new CommentRes();
            commentRes.setId(comment.getId());
            commentRes.setContents(comment.getContents());
            commentRes.setMemberId(comment.getMember().getId());
            commentRes.setPostId(comment.getPost().getId());
            commentRes.setRegDate(comment.getRegDate());
            commentRes.setLastUpdateDate(comment.getLastUpdateDate());
            commentRes.setDeleted(comment.isDeleted());
            if (comment.getParentComment() != null) {
                commentRes.setParentCommentId(comment.getParentComment().getId());
            }
            commentResList.add(commentRes);
        });

        return commentResList;
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

}
