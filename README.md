# ThuattoanmahoaRSA
Thuật toán mã hóa giải mã RSA
# 🔒 Triển khai Thuật toán RSA Đơn giản trong Java

Đây là một triển khai cơ bản của **Thuật toán Mã hóa Khóa Công khai RSA** (Rivest–Shamir–Adleman) sử dụng lớp `java.math.BigInteger` của Java để xử lý các số nguyên lớn.

-----

## ✨ Tính năng

  * **Tạo Khóa:** Tự động tạo các số nguyên tố lớn $p$ và $q$, mô-đun $n$, hàm Carmichael/Euler $\phi(n)$, khóa công khai $e$, và khóa riêng tư $d$.
  * **Mã hóa:** Mã hóa thông điệp bằng cách sử dụng khóa công khai của đối tác ($e$ và $n$).
  * **Giải mã:** Giải mã bản mã thành thông điệp gốc bằng khóa riêng tư ($d$ và $n$).

-----

## 🛠️ Công nghệ Sử dụng

  * **Ngôn ngữ:** Java
  * **Thư viện:** `java.math.BigInteger` (để xử lý các số nguyên rất lớn cần thiết cho bảo mật RSA).

-----

## 📂 Cấu trúc Tệp

Chương trình bao gồm hai tệp Java chính:

  * `RSA.java`: Chứa lớp `RSA` xử lý việc tạo khóa, mã hóa và giải mã.
  * `Main.java`: Chứa lớp `Main` minh họa cách sử dụng lớp `RSA` giữa hai "người" (`person1` và `person2`).

-----

## 📖 Chi tiết Kỹ thuật

### 1\. `RSA.java`

| Thuộc tính / Hằng số | Vai trò | Công thức / Giá trị |
| :--- | :--- | :--- |
| `VERSION` | Độ dài bit của mô-đun $n$ (khóa công khai). | `1024` (phân chia thành $p$ và $q$ mỗi bên 512 bit) |
| `E` (Khóa Công khai) | Số mũ mã hóa tiêu chuẩn. | $\text{BigInteger("65537")}$ |
| $p, q$ | Các số nguyên tố lớn bí mật. | $\text{probablePrime(VERSION / 2, Random)}$ |
| $n$ (Mô-đun) | Mô-đun công khai. | $n = p \cdot q$ |
| $\phi N$ (phiN) | Hàm Euler/Carmichael (dùng để tính $d$). | $\phi(n) = (p-1) \cdot (q-1)$ |
| $d$ (Khóa Riêng tư) | Số mũ giải mã bí mật. | $d = E^{-1} \pmod{\phi N}$ |

#### Phương thức Quan trọng

  * `intialize()`: Thực hiện tất cả các bước **Tạo Khóa** đã liệt kê ở trên.
  * `encrypt(message, partnerN)`: Mã hóa thông điệp $M$: $$C = M^E \pmod{\text{partnerN}}$$
  * `decrypt(cipher)`: Giải mã bản mã $C$: $$M = C^d \pmod{n}$$

### 2\. `Main.java`

Lớp này mô phỏng một kịch bản giao tiếp:

1.  Tạo hai thực thể `RSA`: `person1` và `person2`.
2.  Mỗi thực thể gọi `intialize()` để tạo cặp khóa riêng.
3.  `person1` **mã hóa** một thông điệp (`23052021`) bằng cách sử dụng khóa công khai của `person2` (`person2.getN()`).
4.  `person2` **giải mã** bản mã nhận được bằng khóa riêng tư của mình.
5.  In thông điệp gốc và thông điệp đã giải mã để xác minh.

-----

## 🚀 Cách Chạy Chương trình

1.  **Lưu tệp:** Đảm bảo cả hai tệp `RSA.java` và `Main.java` nằm trong cùng một thư mục.
2.  **Biên dịch:** Mở terminal hoặc command prompt và biên dịch các tệp:
    ```bash
    javac RSA.java Main.java
    ```
3.  **Thực thi:** Chạy lớp `Main`:
    ```bash
    java Main
    ```

### Kết quả Đầu ra Dự kiến

Chương trình sẽ in ra thông điệp gốc và thông điệp đã giải mã, chúng phải khớp nhau, minh họa rằng quá trình mã hóa và giải mã đã thành công.

```
23052021
23052021
```
