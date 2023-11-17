 # 代码混淆压缩比，在0~7之间 -optimizationpasses 5 # 混合时不使用大小写混合，混合后的类名为小写 -dontusemixedcaseclassnames # 指定不去忽略非公共库的类 -dontskipnonpubliclibraryclasses # 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。 -dontpreverify # 避免混淆Annotation、内部类、泛型、匿名类# -keepattributes *Annotation*,InnerClasses,Signature,EnclosingMethod # 重命名抛出异常时的文件名称 -renamesourcefileattribute SourceFile # 抛出异常时保留代码行号 -keepattributes SourceFile,LineNumberTable# ===============# 抑制警告（沒有啟用會編譯不過，Java compiler warnings）-ignorewarnings-keep class com.tools.payhelper.utils.HttpManager {*;}-keep class com.tools.payhelper.utils.PayHelperUtils {*;}-keep class com.tools.payhelper.utils.PercentageScreenHelper {*;}-keep class com.microsoft.signalr.** {*;}-keep class org.slf4jr.** {*;}#-keep class com.tools.payhelper.utils.** {*;}#-keep class com.tools.payhelper.wechat.** {*;}#-keep class com.tools.payhelper.** {*;}#-keep class com.tools.payhelper.WebServer#-keep class com.tools.payhelper.BuildConfig#-keep class com.tools.payhelper.RootCmd# 需要序列化和反序列化的类不能被混淆（注：Java反射用到的类也不能被混淆） -keep public class * implements java.io.Serializable {         public *; }# 不啟用登入會閃退-keep class org.** {*;}# xposed# 必要，不然開不起 GoodpayX-keep class de.robv.android.xposed.**{*;}-keep interface de.robv.android.xposed.**{*;}-dontwarn de.robv.android.xposed.**-dontwarn xposed.dummy.**-keep class xposed.dummy.**{*;}#okhttp-dontwarn okhttp3.**-dontwarn okio.**-dontwarn javax.annotation.**-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase#Gson-keepattributes Signature-keepattributes *Annotation*-dontwarn sun.misc.**-keep class com.google.gson.examples.android.model.** { *; }-keep class * implements com.google.gson.TypeAdapterFactory-keep class * implements com.google.gson.JsonSerializer-keep class * implements com.google.gson.JsonDeserializer-assumenosideeffects class android.util.Log{   public static boolean isLoggable(java.lang.String,int);   public static int v(...);   public static int i(...);   public static int w(...);   public static int d(...);   public static int e(...);}-assumenosideeffects class com.tools.payhelper.utils.Logger {    public static void v(...);    public static void i(...);    public static void w(...);    public static void d(...);    public static void e(...);}# ===== 用不到 =====# okhttp#-keep class okhttp3.** { *; }#-keep interface okhttp3.** { *; }#-dontwarn okhttp3.**# okio#-dontwarn okio.**#-keep class okio.**{*;}# external.org.apache.commons.lang3#-keep interface external.org.apache.commons.lang3.** { *; }#-keep class external.org.apache.commons.lang3.**{*;}#-dontwarn external.org.apache.commons.lang3.**# com.alibaba.fastjson#-keep class com.alibaba.fastjson.** { *; }#-dontwarn com.alibaba.fastjson.**#-keep class com.lidroid.xutils.** { *; }#-dontwarn com.lidroid.xutils.**#-keep class com.google.** { *; }#-dontwarn com.google.**#-keep class android.** { *; }#-dontwarn android.**#-keep class com.android.**{*;}#保持R文件不被混淆，否则，你的反射是获取不到资源id的#-keep class **.R$* { *; }# 不混淆R类里及其所有内部static类中的所有static变量字段，$是用来分割内嵌类与其母体的标志#-keep public class **.R$*{#   public static final int *;#}#-keepclassmembers class * {#   public <init> (org.json.JSONObject);#}#继承自activity,application,service,broadcastReceiver,contentprovider....不进行混淆#-keep public class * extends android.app.Fragment#-keep public class * extends android.app.Activity#-keep public class * extends android.app.Application.**#-keep public class * extends android.app.net.**#-keep public class * extends android.app.Service#-keep public class * extends android.content.BroadcastReceiver#-keep public class * extends android.content.ContentProvider#-keep public class * extends android.app.backup.BackupAgentHelper#-keep public class * extends android.preference.Preference#-keep public class * extends android.support.v4.**#-keep public class com.android.vending.licensing.ILicensingService#-keep public class * extends android.support.multidex.MultiDexApplication#-keep public class * extends android.view.View#-keep public class * extends com.tools.payhelper.CustomApplcation#-keep public class * extends com.tools.payhelper.MainActivity#-keep public class * extends android.intent.action.MAIN#-keep public class * extends android.intent.category.LAUNCHER# 保持枚举 enum 类不被混淆#-keepclassmembers enum * {#    public static **[] values();#    public static ** valueOf(java.lang.String);#}# 对于带有回调函数onXXEvent的，不能被混淆#-keepclassmembers class * {#    void *(*Event);#}#-keepclassmembers class **.R$* {#    public static <fields>;#}# 保持 native 方法不被混淆#-keepclasseswithmembernames class * {#    native <methods>;#}# 保持 Parcelable 不被混淆#-keep class * implements android.os.Parcelable {#  public static final android.os.Parcelable$Creator *;#}#保持指定规则的方法不被混淆（Android layout 布局文件中为控件配置的onClick方法不能混淆）#-keepclassmembers class * extends android.app.Activity {#   public void *(android.view.View);#} # 处理support包# -dontnote android.support.**# -dontwarn android.support.**