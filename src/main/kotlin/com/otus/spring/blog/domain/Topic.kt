package com.otus.spring.blog.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "topics")
class Topic(
    @ManyToOne
        @JoinColumn(name = "author_id", nullable = false)
        var author: Author? = null,

    @Column(nullable = false)
        var text: String? = null,

    @Column(nullable = false, length = 100)
        var title: String? = null,

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

    @Column(nullable = false)
        var createdAt: LocalDateTime? = LocalDateTime.now()
)