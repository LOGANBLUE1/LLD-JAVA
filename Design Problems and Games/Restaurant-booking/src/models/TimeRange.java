package models;

import java.time.LocalDateTime;

public final class TimeRange {
    public final LocalDateTime start; // inclusive
    public final LocalDateTime end;   // exclusive
    public TimeRange(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null || !end.isAfter(start)) {
            throw new IllegalArgumentException("Invalid time range");
        }
        this.start = start; this.end = end;
    }
    public boolean overlaps(TimeRange o) {
        // [a,b) overlaps [c,d) iff a < d && c < b
        return this.start.isBefore(o.end) && o.start.isBefore(this.end);
    }
}