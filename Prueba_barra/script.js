document.addEventListener('DOMContentLoaded', () => {
    const progressBar = document.getElementById('progressBar');
    const steps = [
      { width: '25%', color: 'purple', stepId: 'step1' },
      { width: '50%', color: 'red', stepId: 'step2' },
      { width: '75%', color: 'yellow', stepId: 'step3' },
      { width: '100%', color: 'green', stepId: 'step4' },
    ];
  
    let currentStep = 0;
  
    const updateProgressBar = () => {
      if (currentStep < steps.length) {
        const step = steps[currentStep];
        progressBar.style.width = step.width;
        progressBar.style.backgroundColor = step.color;
  
        steps.forEach(({ stepId }, index) => {
          const stepElement = document.getElementById(stepId);
          stepElement.style.display = index === currentStep ? 'block' : 'none';
        });
  
        currentStep++;
      }
    };
  
    updateProgressBar();
    setInterval(updateProgressBar, 6000); // Actualiza cada minuto
  });
  