LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit main-user systemd

SRC_URI = " \
	file://bashrc \
	file://bash_profile \
	file://flathub.sh \
	file://flathub.service \
	file://system-auth \
	file://gsettings \
	file://nwg-look.desktop \
"

do_install() {
	install -d ${D}${systemd_system_unitdir} ${D}${bindir} ${D}${sysconfdir}/pam.d
	install -d ${D}${MAIN_USER_HOMEDIR}/.config/autostart
	install -d ${D}${MAIN_USER_HOMEDIR}/.icons/default
	install -d ${D}${MAIN_USER_HOMEDIR}/.local/share/nwg-look
	install -m 0644 ${WORKDIR}/flathub.service ${D}${systemd_system_unitdir}
	install -m 0755 ${WORKDIR}/flathub.sh ${D}${bindir}/flathub.sh
	install -m 0644 ${WORKDIR}/bash_profile ${D}${MAIN_USER_HOMEDIR}/.bash_profile
	install -m 0644 ${WORKDIR}/bashrc ${D}${MAIN_USER_HOMEDIR}/.bashrc
	install -m 0644 ${WORKDIR}/system-auth ${D}${sysconfdir}/pam.d
	install -m 0644 ${WORKDIR}/gsettings ${D}${MAIN_USER_HOMEDIR}/.local/share/nwg-look
	install -m 0644 ${WORKDIR}/nwg-look.desktop ${D}${MAIN_USER_HOMEDIR}/.config/autostart
        chown ${MAIN_USER_NAME}:${MAIN_USER_NAME} -R ${D}${MAIN_USER_HOMEDIR}
}

SYSTEMD_PACKAGES = "${PN}-flathub"
SYSTEMD_SERVICE:${PN}-flathub = "flathub.service"
SYSTEMD_AUTO_ENABLE:${PN}-flathub = "enable"

PACKAGES += "${PN}-flathub"

FILES:${PN} = "${MAIN_USER_HOMEDIR} ${sysconfdir}"
FILES:${PN}-flathub = "${bindir}/flathub.sh ${systemd_system_unitdir}/flathub.service"

INSANE_SKIP:${PN} = "host-user-contaminated"

