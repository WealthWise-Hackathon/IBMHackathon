let sidebar;
let content;
let stretchtext;

function toggleSidebar() {
    sidebar = document.querySelector(".sidebar");

    content = document.querySelector(".content");
    stretchtext = document.querySelector(".toggle-menu-btn div");
    if (sidebar.style.left === "-135px") {
        smoothOpenSidebar();
    } else {
        smoothCloseSidebar();
    }
}

async function smoothCloseSidebar() {
    const time = 0.5;
    const steps = 100;
    let eased;
    let x_scale;
    for (let i = 0; i <= steps; i++) {
        eased = easeOutQuad(i / steps);
        sidebar.style.left = lerp(-15, -135, eased) + "px";
        content.style.marginLeft = lerp(160, 40, eased) + "px";
        x_scale = 1 - 2 * eased;
        stretchtext.style.transform = "scale(" + x_scale + ",2.5)";
        await wait(time / steps);
    }
    stretchtext.style.transform = "scale(-1,2.5)";
}

async function smoothOpenSidebar() {
    const time = 0.5;
    const steps = 100;
    let eased;
    let x_scale;
    for (let i = 0; i <= steps; i++) {
        eased = easeOutQuad(i / steps);
        sidebar.style.left = lerp(-130, -15, eased) + "px";
        content.style.marginLeft = lerp(50, 160, eased) + "px";
        x_scale = 2 * eased - 1;
        stretchtext.style.transform = "scale(" + x_scale + ",2.5)";
        await wait(time / steps);
    }
}

async function wait(seconds) {
    return new Promise((resolve) => {
        setTimeout(resolve, seconds * 1000);
    });
}

function lerp(start, end, t) {
    return start * (1 - t) + end * t;
}

function easeOutQuad(t) {
    return t * (2 - t);
}
function easeOutCubic(t) {
    return (t - 1) ** 3 + 1;
}
