import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ronan Watkins on 21/08/2017.
 */
public class Blockchain {
    ArrayList<Block> chain = new ArrayList<Block>();

    public Blockchain() {
        this.chain.add(this.createGenesisBlock());
    }

    public Block createGenesisBlock() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = simpleDateFormat.format(new Date());
        return new Block(0, date, "Genesis block", "0");
    }

    public Block getLatestBlock() {
        return this.chain.get(this.chain.size()-1);
    }

    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(this.getLatestBlock().calculateHash());
        newBlock.setHash(newBlock.calculateHash());
        this.chain.add(newBlock);
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        array.put(this.chain.toString());
        obj.put("chain", array);

        return obj.toString().replace("\\", "");
    }
}
