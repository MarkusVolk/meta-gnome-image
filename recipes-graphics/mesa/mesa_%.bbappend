PACKAGECONFIG:append = " vulkan-beta"
PACKAGECONFIG:append:rpi = " broadcom"
PACKAGECONFIG:append:aarch64 = " panfrost"
PACKAGECONFIG:append:x86 = " va gallium gallium-llvm r600 dri3"
PACKAGECONFIG:append:x86-64 = " va gallium gallium-llvm r600 dri3"

EXTRA_OEMESON += " \
    ${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', '-Dvideo-codecs=vc1dec,h264dec,h264enc,h265dec,h265enc', '', d)} \
"
