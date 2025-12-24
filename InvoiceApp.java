package exercise08;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 請求書管理アプリの実行クラス
 */
public class InvoiceApp {

	public static void main(String[] args) {
		// 請求書データを格納するリストを用意
		ArrayList<Invoice> lists = new ArrayList<>();

		System.out.println("=== 請求書管理アプリ ===\n");

		// 初期データとして2件の法人請求を追加
		Invoice list_1 = null;
		Invoice list_2 = null;

		try {
			list_1 = new CorporateInvoice("株式会社xxx", 23293, "00232");
			list_2 = new CorporateInvoice("株式会社yyy", 98987, "03294");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		lists.add(list_1);
		lists.add(list_2);

		// 現在の請求一覧を表示
		for (Invoice list : lists) {
			list.showInvoice();
		}

		// 請求の削除機能（取引先名で検索して削除）
		System.out.println();
		System.out.println("削除したい取引先名　> ");
		Scanner sc = new Scanner(System.in);
		String target = sc.nextLine();

		Invoice found = null;
		boolean status = false;

		for (Invoice list : lists) {
			String eachClient = list.getClientName();

			if (target.equals(eachClient)) {
				found = list;
				status = true;
				break;
			}
		}

		if (status == true) {
			lists.remove(found);
			System.out.println("削除しました");
		} else {
			System.out.println("削除対象が見つかりません");
		}

		// 削除結果の表示
		for (Invoice list : lists) {
			list.showInvoice();
		}

		// 合計請求金額を計算

		System.out.println("\n--- 合計請求額 ---");

		int sum = 0;

		for (Invoice list : lists) {
			sum += list.getAmount();
		}
		System.out.println(sum);
	}
}
