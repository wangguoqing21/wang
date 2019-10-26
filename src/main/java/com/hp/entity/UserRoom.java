package com.hp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_user_room")
public class UserRoom {
    private int id;
    private User user;
    private Room room;
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @ManyToOne
    @JoinColumn(name="room_id")
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }

	@Override
	public String toString() {
		return "UserRoom [id=" + id + ", user=" + user + ", room=" + room + "]";
	}


   

    
}
