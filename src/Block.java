import java.security.MessageDigest;
import org.json.JSONObject;

/**
 * Created by Ronan Watkins on 21/08/2017.
 */
public class Block {
    private int index;
    public String timestamp;
    private String data;
    public String previousHash;
    public String hash;

    public Block (int index, String timestamp, String data, String previousHash ) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
    }

    public String calculateHash() {
        //JSONObject obj = new JSONObject(this.data);
        //String base = this.index + this.previousHash + this.timestamp + obj;
        String base = this.index + this.previousHash + this.timestamp + this.data;

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject();

        obj.put("timestamp", this.timestamp);
        obj.put("hash", this.hash);
        obj.put("previousHash", this.previousHash);
        obj.put("index", this.index);
        obj.put("data", this.data);

        return obj.toString();
    }
}
