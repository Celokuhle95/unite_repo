package com.cmssc.unite.unite.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Friend initiator;

    @OneToOne(cascade = CascadeType.ALL)
    private Friend acceptor;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Friend getInitiator() {
        return initiator;
    }

    public void setInitiator(Friend initiator) {
        this.initiator = initiator;
    }

    public Friend getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(Friend acceptor) {
        this.acceptor = acceptor;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
