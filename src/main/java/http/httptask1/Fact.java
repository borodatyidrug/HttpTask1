package http.httptask1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fact {
    
    private final String id;
    private final String fact;
    private final String type;
    private final String user;
    private final Integer upVotes;

    public Fact(
            @JsonProperty("id") String id, 
            @JsonProperty("text") String fact, 
            @JsonProperty("type") String type, 
            @JsonProperty("user") String user, 
            @JsonProperty("upvotes") Integer upVotes) {
        this.id = id;
        this.fact = fact;
        this.type = type;
        this.user = user;
        this.upVotes = upVotes;
    }
    
    @Override
    public String toString() {
        return "Fact{id=" + id + ", text=" + fact + ", type=" + type
                + ", user=" + user + ", upVotes=" + upVotes + "}";
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return fact;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUpVotes() {
        return upVotes;
    }
}
