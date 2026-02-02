using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.UIElements;
using UnityEngine.SceneManagement;




public class PlayerController : MonoBehaviour
{

    public float thrustForce = 1f;
    public float maxSpeed = 5f;
    public GameObject boosterFlame;
    private float elapsedTime = 0f;
    private float score = 0f;
    public float scoreMultiplier = 10f;
    public UIDocument uiDocument;
    private Label scoreText;
    public GameObject explosionEffect;
    private Button restartButton;








    Rigidbody2D rb;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        rb=GetComponent<Rigidbody2D>();
        scoreText = uiDocument.rootVisualElement.Q<Label>("ScoreLabel");
        restartButton = uiDocument.rootVisualElement.Q<Button>("RestartButton");
        scoreText.style.display = DisplayStyle.None;
        restartButton.style.display = DisplayStyle.None;
        restartButton.clicked += ReloadScene;

    }

    // Update is called once per frame
    void Update()
    {
        elapsedTime += Time.deltaTime;
        score = Mathf.FloorToInt(elapsedTime * scoreMultiplier);
        scoreText.text = "Puntuacion: " + score;


        if (Mouse.current.leftButton.isPressed){
            //Calcular la direccion del mouse
            Vector3 mousePos = Camera.main.ScreenToWorldPoint(Mouse.current.position.value);
            Vector2 direction = (mousePos - transform.position).normalized;

            //Mover el objeto hacia la direccion del mouse
            transform.up = direction;
            rb.AddForce(direction * thrustForce);

            if (rb.linearVelocity.magnitude > maxSpeed)
            {
            rb.linearVelocity = rb.linearVelocity.normalized * maxSpeed;
            }
        }

        if (Mouse.current.leftButton.wasPressedThisFrame)
        {
        boosterFlame.SetActive(true);
        }
        else if (Mouse.current.leftButton.wasReleasedThisFrame)
        {
        boosterFlame.SetActive(false);
        }
    }

    void OnCollisionEnter2D(Collision2D collision){

        
        //Destruye cuando hay una colision
        Destroy(gameObject);
        Instantiate(explosionEffect, transform.position, transform.rotation);
        restartButton.style.display = DisplayStyle.Flex;
        scoreText.style.display = DisplayStyle.Flex;



    }

    void ReloadScene(){
    SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }
}
