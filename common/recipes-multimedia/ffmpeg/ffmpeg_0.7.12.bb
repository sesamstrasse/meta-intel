require ffmpeg.inc

LICENSE = "LGPLv2.1+ & GPLv2+"
PR = "${INC_PR}.2"

SRC_URI = "http://ffmpeg.org/releases/ffmpeg-${PV}.tar.bz2"
SRC_URI[md5sum] = "b4e3653b2dd930cfa2a80722f8b03182"
SRC_URI[sha256sum] = "786511d75e5a1f95ec16ed9f0b4a3f49f145e134b8f2ccdfa9ecd2d35ff36000"

LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://libpostproc/postprocess.c;beginline=8;endline=21;md5=3163771dd725805aeda961a4e05173b5 \
                    file://COPYING.LGPLv2.1;md5=e344c8fa836c3a41c4cbd79d7bd3a379 \
                    file://ffmpeg.c;beginline=7;endline=20;md5=9dee9cc51a9da6c3254d39ebf4d5aa03"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF_mipsel = "--arch=mips"

EXTRA_OECONF = " \
        --arch=${TARGET_ARCH} \
        --cross-prefix=${TARGET_PREFIX} \
        --disable-stripping \
        --enable-cross-compile \
        --enable-libtheora  \
        --enable-libvorbis \
        --enable-pthreads \
        --enable-shared \
        --enable-swscale \
        --enable-vaapi \
        --enable-gpl \
        --enable-yasm \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        --sysroot="${STAGING_DIR_TARGET}" \
        --prefix=${prefix}/ \
        --target-os=linux \
        ${EXTRA_FFCONF} \
"

do_configure() {
        ./configure ${EXTRA_OECONF}
}

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"
