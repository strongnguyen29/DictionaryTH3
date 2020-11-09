package trunghieu.com.models;

public class Word {
    /**
     * Từ tiếng anh
     */
    protected String target;

    /**
     * Giải nghĩa tiếng việt
     */
    protected String explain;

    /**
     * Constructor
     */
    public Word() {

    }

    /**
     * Constructor
     * @param target String
     * @param explain String
     */
    public Word(String target, String explain) {
        this.target = target;
        this.explain = explain;
    }

    /**
     * Get value target
     *
     * @return String
     */
    public String getTarget() {
        return target;
    }

    /**
     * Set value target
     *
     * @param target String
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Get value explain
     *
     * @return String
     */
    public String getExplain() {
        return explain;
    }

    /**
     * Set value explain
     *
     * @param explain String
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }
}
