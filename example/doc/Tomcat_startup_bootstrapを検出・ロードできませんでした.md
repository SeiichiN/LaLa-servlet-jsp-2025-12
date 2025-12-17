Eclipseでサーブレット・JSPを書いています。サーブレットを書いてコードを実行すると、

「エラー: メイン・クラスorg.apache.catalina.startup.Bootstrapを検出およびロードできませんでした原因: java.lang.ClassNotFoundException: org.apache.catalina.startup.Bootstrap」

というエラーが出ます。そこで、「ウィンドウ」--「設定」--「サーバー」--「ランタイム環境」
を確認すると、ちゃんと、「Tomcat10 Java(21)」になっています。

念のため、Tomcat10 のディレクトリを「編集」で再指定して、「適用」してから、
サーバーを再起動すると、今度はちゃんとサーバーが起動します。

この現象は、"Eclipse 2025-09" "Eclipse 2025-12" のときに起こります。

僕は、この現象は、Eclipse最新版のバグだと思っているのですが、どうでしょうか？


---

とても状況整理が的確です。
結論から言うと、

> **「Tomcat のディレクトリを“再指定して適用すると直る」
> かつ
> 「Eclipse 2025-09 / 2025-12 で再現する」**

この条件がそろっている場合、
**あなたの推測どおり「Eclipse 側の不具合（少なくとも回帰バグ）」と考えるのが妥当**です。

---

## なぜ「設定は正しいのに失敗 → 再指定すると成功」するのか

### 起きている現象を整理すると

1. Eclipse 起動直後 or クリーンでない状態で
2. サーブレット実行（= 内部的に Tomcat を起動）
3. **Tomcat Runtime は「登録済み」と表示されている**
4. しかし実際には

   ```
   org.apache.catalina.startup.Bootstrap
   ```

   が **クラスパスに載っていない状態で起動される**
5. Runtime 設定画面で

   * 何も変えず
   * ディレクトリを「再指定 → 適用」
6. → 以降は正常起動

これはつまり、

> **「Tomcat Runtime の内部キャッシュ or クラスパス構築が壊れた状態で起動される」
> → 再指定すると再構築される**

という動きです。

---

## なぜ Eclipse 2025 系で起きやすいのか

### 技術的背景（推測だが筋が通る）

Eclipse 2025 系では：

* Java 21 が標準化
* WTP（Web Tools Platform）が内部的に更新
* Tomcat 10（Jakarta EE 10/11）対応の調整

この影響で、

* **Tomcat Runtime の classpath 解決タイミング**
* **Servers ビューの初期化順**
* **workspace metadata の再利用**

あたりに **回帰（regression）** が入っている可能性が高いです。

特に今回の症状は：

* 設定ファイル自体は正しい
* 再保存すると直る
* クリーンビルドや再起動では直らないことがある

👉 **典型的な IDE 側バグの挙動**です。

---

## 「Tomcat が壊れている」線はほぼ否定できる理由

あなたのケースでは：

* Tomcat 10 のディレクトリは正しい
* 再指定後は毎回正常起動
* 同一 Tomcat / 同一 Java 21
* Eclipse の特定バージョンでのみ再現

✔ Tomcat 本体
✔ Java
✔ 設定ミス

はほぼ除外できます。

---

## 実用的な回避策（おすすめ順）

### ① Workspace metadata のリフレッシュ（効果高）

ときどき Eclipse が壊れたサーバー定義を掴み続けます。

```text
Serversビュー
 → Tomcat v10.x Server at localhost
 → 右クリック
 → Clean
 → Clean Tomcat Work Directory
```

---

### ② Tomcat Runtime を一度「削除 → 再登録」

（毎回再指定する手間を減らせることあり）

```
Window
 → Preferences
 → Server
 → Runtime Environments
 → Tomcat10 を Remove
 → Eclipse 再起動
 → Add で再登録
```

---

### ③ workspace を作り直す（最終手段）

Eclipse のサーバー情報は workspace 依存です。

* 新しい workspace
* プロジェクトを Import
* Tomcat を再登録

これで再発しなくなるケースも多いです。

---

## バグか？という問いへの回答

> **「Eclipse最新版のバグだと思うのですが、どうでしょうか？」**

👉 **はい、その認識でほぼ正しいです。**

少なくとも現時点では：

* ユーザー設定ミスとは考えにくい
* Tomcat / Java の問題でもない
* Eclipse 2025 系特有の挙動

です。

---

## 補足（今後の見通し）

この種の問題は：

* Eclipse の **次のマイナーアップデート**
* WTP プラグイン更新

で **しれっと直る** ことが多いです。

それまでは
👉「Runtime を再指定すると直る」という事実を
**安全な回避策として使う**のが現実的です。

---

必要であれば：

* 「なぜ Bootstrap が classpath に載らないのか」
* 「Servers ビュー内部で何が起きているか」
* 「Eclipse を安定させる設定」

も、もう一段深く解説できますよ。
