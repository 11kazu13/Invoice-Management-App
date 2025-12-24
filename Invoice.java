package exercise08;

/**
 * 請求情報を表す基本クラス
 */
public class Invoice {
	private String clientName;
	private int amount;

	// 引数なしのコンストラクタ（デフォルト値を設定）
	public Invoice() {
		this.clientName = "未設定";
		this.amount = 0;
	}

	// 引数ありコンストラクタ（請求情報を初期化）
	public Invoice(String clientName, int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("請求金額が不正です");
		}

		this.clientName = clientName;
		this.amount = amount;
	}

	// 請求情報をコンソールに出力
	public void showInvoice() {
		System.out.printf("取引先: %s, 金額: %d\n", getClientName(), getAmount());
	}

	// 各フィールドの取得と設定（カプセル化）
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
