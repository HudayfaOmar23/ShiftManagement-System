document.addEventListener('DOMContentLoaded', function() {
    
    if (!document.querySelector('.parallax-bg')) {
        const body = document.querySelector('body');
        
       
        const bg = document.createElement('div');
        bg.className = 'parallax-bg';
        
        
        bg.onerror = function() {
            this.style.background = 'linear-gradient(#121212, #1e1e1e)';
            console.warn('Background image failed to load, using fallback gradient');
        };
        
        
        body.insertBefore(bg, body.firstChild);
        
       
        let lastScroll = 0;
        let ticking = false;
        
        window.addEventListener('scroll', function() {
            lastScroll = window.pageYOffset;
            
            if (!ticking) {
                window.requestAnimationFrame(function() {
                    bg.style.transform = `translateY(${lastScroll * 0.3}px)`;
                    ticking = false;
                });
                ticking = true;
            }
        });
    }
});