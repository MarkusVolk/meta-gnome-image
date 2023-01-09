FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:rockchip = "file://asound.state.rockpi"

do_install:append:rockchip() {
	install -m0644 ${WORKDIR}/asound.state.rockpi ${D}${localstatedir}/lib/alsa/asound.state
}

