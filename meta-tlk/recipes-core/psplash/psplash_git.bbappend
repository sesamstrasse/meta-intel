FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "gdk-pixbuf-native"

PRINC := "${@int(PRINC) + 7}"

# NB: this is only for the main logo image; if you add multiple images here,
# poky will build multiple psplash packages with 'outsuffix' in name for
# each of these ...
SPLASH_IMAGES = "file://psplash-tlk.png;outsuffix=default"
