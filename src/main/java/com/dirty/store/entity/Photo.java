package com.dirty.store.entity;

import com.dirty.store.entity.base.IndexEntity;
import lombok.*;

import javax.persistence.*;
import java.net.URL;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(name = "photos")
public class Photo extends IndexEntity {

    @Column(name = "ord_id")
    private Integer ordId;

    @Column(name = "main_url")
    private URL mainUrl;

    @Column(name = "thumb_url")
    private URL thumbUrl;

    @Column(name = "original_url")
    private URL originalUrl;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

}
