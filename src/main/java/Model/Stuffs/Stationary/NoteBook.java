package Model.Stuffs.Stationary;

public class NoteBook extends Stationary {
    private String paperMaterial;
    private int paperCount;

    public NoteBook(String name, double price, int count, String producerCountry, String paperMaterial, int paperCount) {
        super(name, price, count, producerCountry);
        this.paperMaterial = paperMaterial;
        this.paperCount = paperCount;
    }

    public String getPaperMaterial() {
        return paperMaterial;
    }

    public void setPaperMaterial(String paperMaterial) {
        this.paperMaterial = paperMaterial;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    @Override
    public String toString() {
        return super.toString() +
                "paperMaterial: " + paperMaterial +
                ", paperCount=" + paperCount;
    }
}
