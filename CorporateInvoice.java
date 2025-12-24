package exercise08;

/**
 * 法人請求を表すサブクラス（Invoiceクラスを継承）
 */
public class CorporateInvoice extends Invoice {
    // 法人ID（例：法人番号）
	private String corporateId; 

    // デフォルトコンストラクタ
    public CorporateInvoice() {
    	super();
    	this.corporateId = "未設定";
    }

    // 引数ありコンストラクタ（親の情報も初期化）
    public CorporateInvoice(String clientName, int amount, String corporateId) {
    	super(clientName, amount);
    	this.corporateId = corporateId;
    }

    // 請求情報を出力（親のshowInvoiceをオーバーライド）
    @Override
    public void showInvoice() {
    	System.out.printf("取引先: %s, 金額: %d, 法人ID: %s\n", getClientName(), getAmount(), getCorporateId());
    }

    // 法人IDの取得・設定
    public String getCorporateId() {
    	return this.corporateId;
    }

    public void setCorporateId(String corporateId) {
    	this.corporateId = corporateId;
    }
}
