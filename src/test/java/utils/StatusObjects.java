package utils;

import net.minidev.json.JSONObject;
import static utils.JsonObjectsUtils.*;

public class StatusObjects {
    public static final JSONObject SUCCESS_STATUS = createStatusObject("OK", "No error");
    public static final JSONObject UNAUTHORIZED_STATUS = createStatusObject("API-ERR-003", "Uygun yetkiniz yok.");
    public static final JSONObject INVALID_LENGTH_PASSWORD_STATUS = createStatusObject("API-ERR-011", "Şifre uzunluğu uygun değil.");
    public static final JSONObject INVALID_FORMAT_PASSWORD_STATUS = createStatusObject("API-ERR-012", "Şifre sayılardan oluşmalıdır.");
    public static final JSONObject INVALID_CURRENT_PASSWORD_STATUS = createStatusObject("API-ERR-028", "Mobil kullanıcının mevcut şifresi yanlış.");
    public static final JSONObject INVALID_MSISDN_STATUS = createStatusObject("API-ERR-007", "Kullanıcı bulunamadı.");
    public static final JSONObject REGISTER_WITH_INVALID_IDENTITY_STATUS = createStatusObject("API-ERR-025", "Kimlik numarası geçersiz.");
    public static final JSONObject REGISTER_WITH_UNAPPROVED_MANDATORY_AGREEMENT_STATUS = createStatusObject("API-ERR-047", "Zorunlu sözleşme onaylanmadı.");
    public static final JSONObject REGISTER_WITH_EXIST_USER_STATUS = createStatusObject("API-ERR-010", "Mobil kullanıcı zaten mevcut.");
    public static final JSONObject INVALID_REFRESH_TOKEN_STATUS = createStatusObject("API-ERR-023","RefreshToken'ın süresi dolmuş veya geçersiz. Yeni bir Giriş İsteği yapmanız gerekecektir.");
    public static final JSONObject BLOCK_OTP_STATUS = createStatusObject("API-ERR-013","OTP yeniden deneme sayısı 1 gün boyunca engellendi.");
    public static final JSONObject UNKNOWN_ERROR_STATUS = createStatusObject("API-ERR-000","Bilinmeyen hata oluştu. Lütfen bir yöneticiyle iletişime geçin.");
    public static final JSONObject INVALID_OTP_STATUS = createStatusObject("API-ERR-016","OTP kodu yanlış, lütfen tekrar deneyin.");
    public static final JSONObject OTP_RETRY_LIMIT_EXCEED_STATUS = createStatusObject("API-ERR-015","OTP deneme sayısı aşıldı.");
    public static final JSONObject INVALID_CAMPAIGN_ID_STATUS = createStatusObject("API-ERR-022","Avantaj bulunamadı.");
    public static final JSONObject INVALID_COMPANY_KEY_STATUS = createStatusObject("API-ERR-034","Kullanıcı bu şirkete ait değil.");
    public static final JSONObject EXPIRED_DISCOUNT_CODE_STATUS = createStatusObject("API-ERR-020","İndirim kodu kullanım süresi dolmuştur.");
    public static final JSONObject VALIDATION_ERROR_STATUS = createStatusObject("API-ERR-001", "Validation error");
    public static final JSONObject EXIST_REQUEST_ID_STATUS = createStatusObject("API-ERR-049", "Transaction request id zaten kullanılıyor.");
    public static final JSONObject EXIST_ORDER_ID_STATUS = createStatusObject("API-ERR-048", "Transaction order id zaten kullanılıyor.");
}
