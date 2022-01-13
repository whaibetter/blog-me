package cn.blog.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * video
 * @author 
 */
@Data
public class Video implements Serializable {
    private Integer videoId;

    private String videoTitle;

    private String videoLocation;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Video other = (Video) that;
        return (this.getVideoId() == null ? other.getVideoId() == null : this.getVideoId().equals(other.getVideoId()))
            && (this.getVideoTitle() == null ? other.getVideoTitle() == null : this.getVideoTitle().equals(other.getVideoTitle()))
            && (this.getVideoLocation() == null ? other.getVideoLocation() == null : this.getVideoLocation().equals(other.getVideoLocation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVideoId() == null) ? 0 : getVideoId().hashCode());
        result = prime * result + ((getVideoTitle() == null) ? 0 : getVideoTitle().hashCode());
        result = prime * result + ((getVideoLocation() == null) ? 0 : getVideoLocation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoId=").append(videoId);
        sb.append(", videoTitle=").append(videoTitle);
        sb.append(", videoLocation=").append(videoLocation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}