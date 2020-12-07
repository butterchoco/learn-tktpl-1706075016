#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_id_ac_ui_mobprog_supri_tugas1_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz,
                                                              jint is_angry) {
    std::string hello;
    if (is_angry) {
        hello = "Go Away!";
    } else {
        hello = "Come away...";
    }
    return env->NewStringUTF(hello.c_str());
}