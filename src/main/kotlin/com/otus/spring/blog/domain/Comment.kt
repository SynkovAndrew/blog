package com.otus.spring.blog.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "comments")
class Comment(
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    var author: Author? = null,

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    var topic: Topic? = null,

    @Column(nullable = false)
    var text: String? = null,

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

    @Column(nullable = false)
        var createdAt: LocalDateTime? = LocalDateTime.now()
)