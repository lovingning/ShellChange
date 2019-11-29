# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
-dontoptimize
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this one from your
# project.properties file.




# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native


# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations





# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.


# Understand the @Keep support annotation.
-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}


#keep源文件及行号
-keepattributes SourceFile,LineNumberTable
#制定代码压缩级别
-optimizationpasses 5
#包名不混合大小写
-dontusemixedcaseclassnames
#不忽略非公共的类库
-dontskipnonpubliclibraryclasses
#不优化输入的类文件
-dontoptimize
#不做预校验
-dontpreverify
#混淆时记录日志
-verbose
#混淆采用的算法
#-optimizations
#忽略警告
-ignorewarnings
#避免混淆泛型
-keepattributes Signature

##apk 包内所有class内部结构
#-dump class files.txt
##列出未混淆的类和成员
#-printseeds seeds.txt
##列出从apk中删除的代码
#-printusage unused.txt
##混淆前后的映射关系
#-printmapping mapping.txt

#不混淆某些特定的类
-keep class * extends android.app.Activity
-keep class * extends android.app.Fragment
-keep class * extends android.app.Application
-keep class * extends android.app.Service
-keep class * extends android.content.BroadcastReceiver
-keep class * extends android.app.ContentProvider
-keep class * extends android.app.backup.BackupAgentHelper
-keep class * extends android.preference.Preference
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService


#-libraryjars libs/litepal-1.5.1.jar
#-libraryjars libs/litepal-1.5.1-src.jar
#-libraryjars libs/ormlite-android-4.48.jar
#-libraryjars libs/ormlite-core-4.48.jar
#-libraryjars libs/ormlite-jdbc-4.48.jar

#保护注解
-keepattributes *Annotation*
#如果引用support包则添加如下
-dontwarn android.support.**
#不混淆native方法
-keepclasseswithmembernames class * {
    native <methods>;
}
#保持Parcelable不被混淆
-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}
#保持Serializable不被混淆
-keepnames class * implements java.io.Serializable
#保持enum类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}

#（可选）避免Log打印输出
-assumenosideeffects class android.util.Log {
   public static *** v(...);
   public static *** d(...);
   public static *** i(...);
   public static *** w(...);
 }

#底部导航栏
-keep public class android.support.design.widget.BottomNavigationView { *; }
-keep public class android.support.design.internal.BottomNavigationMenuView { *; }
-keep public class android.support.design.internal.BottomNavigationPresenter { *; }
-keep public class android.support.design.internal.BottomNavigationItemView { *; }


#keep 保留类名不会被混淆，且成员不会被移除
#keepnames 保留类名不会被混淆，如果成员没有被引用则会移除
#keepclassmembers 只保留类中的成员，防止被混淆或者移除
#keepclassmembernames 只保留类中的成员，防止被混淆，成员没有引用会被移除
#keepclasseswithmembers 保留类和类中的成员，防止被混淆或移除，保留指明的成员
#keepclasseswithmembernames 保留类和类中的成员，防止被混淆，保留指明的成员，成员没有引用会被移除
#<field> 匹配类中的所有字段
#<method> 匹配类中的所有方法
#<init> 匹配类中的所有构造函数
#* 匹配任意长度长度，不包含包名分隔符
#** 匹配任意长度字符，包含包名分隔符(.)
#*** 匹配任意参数类型

# page-module
-keep class com.knowledge.mnlin.page.core.PageProcessor$EnterPoint{*;}

-keepnames class * extends com.knowledge.mnlin.page.interfaces.Page

-keep class * extends com.knowledge.mnlin.page.interfaces.PageGenCombineOperate{*;}