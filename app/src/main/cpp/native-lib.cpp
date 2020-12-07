#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_ahmadsupriyanto_lab6_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject,
        jint isAngry) {
    std::string hello;
    if (isAngry) {
        hello = "Go Away!";
    } else {
        hello = "Come away...";
    }
    return env->NewStringUTF(hello.c_str());
}
