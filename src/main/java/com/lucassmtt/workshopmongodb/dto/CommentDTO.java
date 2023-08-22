package com.lucassmtt.workshopmongodb.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private Instant moment;
    private AuthorDTO authorDTO;
    public CommentDTO() {
    }

    public CommentDTO(String text, Instant moment,AuthorDTO authorDTO) {
        this.text = text;
        this.moment = moment;
        this.authorDTO = authorDTO;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
