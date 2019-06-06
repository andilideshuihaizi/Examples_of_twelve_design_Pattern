#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_hjq_examples_1of_1twelve_1design_1pattern_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
