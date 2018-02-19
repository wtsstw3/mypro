package simple.crystal;

import java.util.*;

public class IntervalSolver {
    public static final int PREV_EQ_NEXT = 1;
    public static final int NEXT_IN_PREV = 2;
    public static final int NEXT_AFTER_PREV = 3;
    public static final int PREV_NOT_INTERSECT_NEXT = 6;

    List<DateValue> ret = null;

    public List<DateValue> merge(List<DateValue> intervals) {
        ret = new LinkedList<>();
        if (intervals.size() == 0)
            return ret;

        sort(intervals);

        DateValue previousInterval = null;

        for (DateValue nextInterval : intervals) {
            if (previousInterval == null) {
                previousInterval = nextInterval;
                continue;
            }


            switch (checkState(nextInterval, previousInterval)) {
                case PREV_EQ_NEXT:
                    if (nextInterval.getValue() != previousInterval.getValue()) {
                        if (nextInterval.isNew()) {
                            previousInterval.setValue(nextInterval.getValue());
                            previousInterval.setNew(nextInterval.isNew());
                        } else {
                            nextInterval.setValue(previousInterval.getValue());
                            nextInterval.setNew(previousInterval.isNew());
                        }
                    }
                    break;
                case NEXT_IN_PREV:
                    if (nextInterval.getValue() != previousInterval.getValue() && (!previousInterval.isNew() && nextInterval.isNew())) {
                        if (!nextInterval.getBeginDate().equals(previousInterval.getBeginDate())) {
                            ret.add(new DateValue(previousInterval.getBeginDate(), nextInterval.getBeginDate(), previousInterval.getValue()));
                            ret.add(new DateValue(nextInterval.getBeginDate(), nextInterval.getEndDate(), nextInterval.getValue()));
                        }
                        nextInterval.setBeginDate(nextInterval.getEndDate());
                        nextInterval.setEndDate(previousInterval.getEndDate());
                        nextInterval.setValue(previousInterval.getValue());
                        previousInterval = nextInterval;
                    }
                    break;
                case NEXT_AFTER_PREV:
                    if (nextInterval.getValue() == previousInterval.getValue()) {
                        previousInterval.setEndDate(nextInterval.getEndDate());
                    } else {
                        if (nextInterval.isNew()) {
                            previousInterval.setEndDate(nextInterval.getBeginDate());
                            previousInterval.setValue(previousInterval.getValue());
                            if (!previousInterval.getBeginDate().equals(previousInterval.getEndDate())) {
                                ret.add(previousInterval);
                            }
                            previousInterval = nextInterval;
                        } else {
                            ret.add(previousInterval);
                            nextInterval.setBeginDate(previousInterval.getEndDate());
                            previousInterval = nextInterval;
                        }
                    }
                    break;
                case PREV_NOT_INTERSECT_NEXT:
                    ret.add(previousInterval);
                    previousInterval = nextInterval;
            }
        }
        ret.add(previousInterval);
        return ret;
    }



    private int checkState(DateValue nextInterval, DateValue previousInterval) {
        if (previousInterval.getBeginDate().compareTo(nextInterval.getBeginDate()) == 0 &&
                previousInterval.getEndDate().compareTo(nextInterval.getEndDate()) == 0) {
            return PREV_EQ_NEXT;
        } else if (previousInterval.getBeginDate().compareTo(nextInterval.getBeginDate()) <= 0) {
            if (previousInterval.getEndDate().compareTo(nextInterval.getEndDate()) < 0 &&
                    (previousInterval.getEndDate().compareTo(nextInterval.getBeginDate()) > 0)) {
                return NEXT_AFTER_PREV;
            } else if (previousInterval.getEndDate().compareTo(nextInterval.getEndDate()) > 0) {
                return NEXT_IN_PREV;
            }
        }
        return PREV_NOT_INTERSECT_NEXT;
    }


    public boolean checkInitialInterval(List<DateValue> intervals) {
        sort(intervals);
        DateValue previousInterval = null;
        for (DateValue nextInterval : intervals) {
            if (previousInterval == null) {
                previousInterval = nextInterval;
                continue;
            }
            if (checkState(nextInterval, previousInterval) != PREV_NOT_INTERSECT_NEXT) {
                return false;
            }
        }
        return true;
    }

    private void sort(List<DateValue> intervals) {
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.getBeginDate().compareTo(o2.getBeginDate()) > 0)
                return 1;
            else if (o1.getBeginDate().compareTo(o2.getBeginDate()) < 0)
                return -1;
            else {
                if (o1.getEndDate().compareTo(o2.getEndDate()) > 0)
                    return 1;
                else if (o1.getEndDate().compareTo(o2.getEndDate()) < 0)
                    return -1;
            }
            if (o1.isNew() != o2.isNew()) {
                if (o1.isNew()) return 1;
                else return -1;
            }
            return 0;
        });
    }
}