package com.otus.spring.blog.service

import com.otus.spring.blog.domain.Comment
import com.otus.spring.blog.domain.Topic
import com.otus.spring.blog.domain.User
import com.otus.spring.blog.dto.*
import org.springframework.stereotype.Service

@Service
class MappingService {
    fun map(u: User) = UserDTO(u.id, u.firstName, u.lastName, u.email, u.birthday, u.createdAt)

    fun map(t: Topic) = TopicDTO(t.createdAt, t.id, map(t.user ?: User()), t.text, t.title)

    fun mapToResponse(t: Topic) = SaveTopicResponseDTO(t.text, t.title, t.createdAt, t.id, t.user?.id)

    fun map(c: Comment) = CommentDTO(c.createdAt, c.id, c.user?.id, c.topic?.id, c.text)

    fun map(r: SaveCommentRequestDTO) = Comment(User(id = r.userId), Topic(id = r.topicId), r.text)

    fun map(r: SaveUserRequestDTO) = User(r.email, r.firstName, r.lastName, r.birthday)

    fun map(r: SaveTopicRequestDTO) = Topic(User(id = r.userId), r.text, r.title)

    fun map(us: List<User>) = FindUsersResponseDTO(us.map { u -> map(u) })

    fun map(ms: List<Topic>) = FindTopicsResponseDTO(ms.map { m -> map(m) })
}