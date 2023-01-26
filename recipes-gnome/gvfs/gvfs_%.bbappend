
PACKAGECONFIG:append = " samba fuse dnssd"

EXTRA_OEMESON += " \
    -Dgoa=true\
    -Dgoogle=true \
    -Dnfs=true \
"

DEPENDS += "libusb1 libgdata libnfs gnome-keyring gnome-online-accounts"
